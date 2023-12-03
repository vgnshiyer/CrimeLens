'''
Author: Vignesh Iyer
Date: 11/17/2023
'''
import csv
from rdflib import Graph, Literal, Namespace, RDF, URIRef, XSD
from rdflib.namespace import FOAF
from utils import data_integration_utility

DBP = Namespace("http://dbpedia.org/resource/")
ns = Namespace("http://www.semanticweb.org/ontologies/2023/11/CrimeLens#")
XSD = Namespace("http://www.w3.org/2001/XMLSchema#")

g = Graph()
g.bind('cl', ns)
g.bind('xsd', XSD)
g.bind('dbp', DBP)
g.bind('foaf', FOAF)

class DataLoader:

    def __init__(self, output_file_path):
        self.output_file_path = output_file_path
        # self.column_mappings = column_mappings

        self.index = 0
        self.crime_ids = set()

    def read_csv(self, input_file_path):
        csvfile = open(input_file_path, 'r', newline='')
        self.reader = csv.DictReader(csvfile)

    def is_existing_crime_event(self, crime_event_id):
        if crime_event_id in self.crime_ids:
            return True
        self.crime_ids.add(crime_event_id)
        return False

    def get_new_row_index(self):
        self.index += 1
        return self.index

    def create_graph(self):
        for row in self.reader:
            crime_event_id = data_integration_utility.get_row_information(row, "id")
            if self.is_existing_crime_event(crime_event_id):
                continue

            # print(row)
            row_index = self.get_new_row_index()
            # print(row_index)
            self.add_victim(row, row_index)
            self.add_perpetrator(row, row_index)
            self.add_location(row, row_index)
            self.add_crime_event(row, row_index)

    def save_graph(self):
        g.serialize(destination=self.output_file_path, format='turtle')

    def add_crime_event(self, row, index):
        crime_event_id = data_integration_utility.get_row_information(row, "id")
        # crime_event_id = data_integration_utility.format_crime_id(crime_event_id)
        crime_event_uri = ns['crime_event' + str(crime_event_id)]
        crime_date = data_integration_utility.get_row_information(row, "crime_date")
        crime_classification = data_integration_utility.get_row_information(row, "description")

        g.add((crime_event_uri, RDF.type, ns['CrimeEvent']))
        g.add((crime_event_uri, ns['hasCrimeID'], Literal(crime_event_id, datatype=XSD.integer)))
        
        g.add((crime_event_uri, ns['hasCrimeDate'], Literal(data_integration_utility.format_date(crime_date), datatype=XSD.date)))
        g.add((crime_event_uri, ns['hasClassification'], Literal(crime_classification, datatype=XSD.string)))

        g.add((crime_event_uri, ns['hasVictimID'], Literal(index, datatype=XSD.integer)))
        g.add((crime_event_uri, ns['hasPerpetratorID'], Literal(index, datatype=XSD.integer)))
        g.add((crime_event_uri, ns['hasLocationID'], Literal(index, datatype=XSD.integer)))

    def add_victim(self, row, victim_id):
        victim_uri = ns['victim' + str(victim_id)]
        # print(row)
        victim_age_group = data_integration_utility.get_row_information(row, "victim_age_range")
        victim_gender = data_integration_utility.get_row_information(row, "victim_gender")
        victim_race = data_integration_utility.get_row_information(row, "victim_race")

        g.add((victim_uri, RDF.type, ns['Victim']))

        g.add((victim_uri, ns['hasVictimID'], Literal(victim_id, datatype=XSD.integer)))
        g.add((victim_uri, FOAF.age, Literal(victim_age_group, datatype=XSD.string)))
        g.add((victim_uri, FOAF.gender, Literal(victim_gender, datatype=XSD.string)))
        g.add((victim_uri, DBP['Race_(human_categorization)'], Literal(victim_race, datatype=XSD.string)))

    def add_perpetrator(self, row, perpetrator_id):
        perpetrator_uri = ns['perpetrator' + str(perpetrator_id)]
        perpetrator_age_group = data_integration_utility.get_row_information(row, "perpetrator_age")
        perpetrator_gender = data_integration_utility.get_row_information(row, "perpetrator_sex")
        perpetrator_race = data_integration_utility.get_row_information(row, "perpetrator_race")

        g.add((perpetrator_uri, RDF.type, ns['Perpetrator']))

        g.add((perpetrator_uri, ns['hasPerpetratorID'], Literal(perpetrator_id, datatype=XSD.integer)))
        g.add((perpetrator_uri, FOAF.age, Literal(perpetrator_age_group, datatype=XSD.string)))
        g.add((perpetrator_uri, FOAF.gender, Literal(perpetrator_gender, datatype=XSD.string)))
        g.add((perpetrator_uri, DBP['Race_(human_categorization)'], Literal(perpetrator_race, datatype=XSD.string)))

    def add_location(self, row, location_id):
        location_uri = ns['location' + str(location_id)]
        location_lat = data_integration_utility.get_row_information(row, "lat")
        location_lon = data_integration_utility.get_row_information(row, "long")
        location_city = data_integration_utility.get_row_information(row, "city")
        location_state = data_integration_utility.get_row_information(row, "state")
        location_street = data_integration_utility.get_row_information(row, "street")

        g.add((location_uri, RDF.type, ns['Location']))
        g.add((location_uri, ns['hasLocationID'], Literal(location_id, datatype=XSD.integer)))

        try:
            g.add((location_uri, DBP.Latitude, Literal(float(location_lat), datatype=XSD.decimal)))
            g.add((location_uri, DBP.Longitude, Literal(float(location_lon), datatype=XSD.decimal)))
        except Exception:
            g.add((location_uri, DBP.Latitude, Literal(0, datatype=XSD.decimal)))
            g.add((location_uri, DBP.Longitude, Literal(0, datatype=XSD.decimal)))

        g.add((location_uri, ns['hasCity'], Literal(location_city, datatype=XSD.string)))
        g.add((location_uri, ns['hasState'], Literal(location_state, datatype=XSD.string)))
        g.add((location_uri, ns['hasStreet'], Literal(location_street, datatype=XSD.string)))

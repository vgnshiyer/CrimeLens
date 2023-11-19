import csv
from rdflib import Graph, Literal, Namespace, RDF, URIRef, XSD
from rdflib.namespace import FOAF
DBP = Namespace("http://dbpedia.org/resource/")

ns = Namespace("http://www.semanticweb.org/ontologies/2023/11/CrimeLens#")
XSD = Namespace("http://www.w3.org/2001/XMLSchema#")

g = Graph()
g.bind('cl', ns)
g.bind('xsd', XSD)
g.bind('dbp', DBP)
g.bind('foaf', FOAF)

'''
    CrimeEvent a owl:Class

    CrimeEvent hasCrimeID Literal
    CrimeEvent hasCrimeDate Literal
    CrimeEvent hasClassification Literal

    Victim a owl:Class
    Victim hasAge Literal
    Victim hasSex Literal
    Victim hasRace Literal

    Location a owl:Class

    Location hasLattiude Decimal
    Location hasLongitude Decimal
    Location hasCity Literal
    Location hasState Literal
    Location hasStreet Literal
'''

class DataLoader:

    def __init__(self, input_file_path, output_file_path):
        self.input_file_path = input_file_path
        self.output_file_path = output_file_path
        self.row_count = 1

    def read_csv(self):
        csvfile = open(self.input_file_path, 'r', newline='')
        self.reader = csv.DictReader(csvfile)

    def create_graph(self):
        for row in self.reader:
            self.add_victim(row)
            self.add_perpetrator(row)
            self.add_location(row)
            self.add_crime_event(row)
            self.row_count += 1

    def save_graph(self):
        g.serialize(destination=self.output_file_path, format='turtle')

    def add_crime_event(self, row):
        crime_event_uri = ns['crime_event' + row['INCIDENT_KEY']]

        g.add((crime_event_uri, RDF.type, ns['CrimeEvent']))

        g.add((crime_event_uri, ns['hasCrimeID'], Literal(row['INCIDENT_KEY'], datatype=XSD.integer)))
        g.add((crime_event_uri, ns['hasCrimeDate'], Literal(row['OCCUR_DATE'], datatype=XSD.date)))

        if 'OFFENSE' in row: # TODO
            g.add((crime_event_uri, ns['hasClassification'], Literal(row['OFFENSE'], datatype=XSD.string)))
        else:
            g.add((crime_event_uri, ns['hasClassification'], Literal('', datatype=XSD.string)))

        g.add((crime_event_uri, ns['hasVictimID'], Literal(self.row_count, datatype=XSD.integer)))
        g.add((crime_event_uri, ns['hasPerpetratorID'], Literal(self.row_count, datatype=XSD.integer)))
        g.add((crime_event_uri, ns['hasLocationID'], Literal(self.row_count, datatype=XSD.integer)))

    def add_victim(self, row):
        victim_uri = ns['victim' + row['INCIDENT_KEY']]

        g.add((victim_uri, RDF.type, FOAF.Person))

        g.add((victim_uri, ns['hasVictimID'], Literal(self.row_count, datatype=XSD.integer)))
        g.add((victim_uri, FOAF.age, Literal(row['VIC_AGE_GROUP'], datatype=XSD.string)))
        g.add((victim_uri, FOAF.gender, Literal(row['VIC_SEX'], datatype=XSD.string)))
        g.add((victim_uri, DBP['Race_(human_categorization)'], Literal(row['VIC_RACE'], datatype=XSD.string)))

    def add_perpetrator(self, row):
        perpetrator_uri = ns['perpetrator' + row['INCIDENT_KEY']]

        g.add((perpetrator_uri, RDF.type, ns['Perpetrator']))

        g.add((perpetrator_uri, ns['hasPerpetratorID'], Literal(self.row_count, datatype=XSD.integer)))
        g.add((perpetrator_uri, FOAF.age, Literal(row['PERP_AGE_GROUP'], datatype=XSD.string)))
        g.add((perpetrator_uri, FOAF.gender, Literal(row['PERP_SEX'], datatype=XSD.string)))
        g.add((perpetrator_uri, DBP['Race_(human_categorization)'], Literal(row['PERP_RACE'], datatype=XSD.string)))

    def add_location(self, row):
        location_uri = ns['location' + row['INCIDENT_KEY']]

        g.add((location_uri, ns['hasLocationID'], Literal(self.row_count, datatype=XSD.integer)))
        g.add((location_uri, RDF.type, ns['Location']))

        try:
            g.add((location_uri, DBP.Latitude, Literal(float(row['Latitude']), datatype=XSD.decimal)))
            g.add((location_uri, DBP.Longitude, Literal(float(row['Longitude']), datatype=XSD.decimal)))
        except ValueError:
            g.add((location_uri, DBP.Latitude, Literal(0, datatype=XSD.decimal)))
            g.add((location_uri, DBP.Longitude, Literal(0, datatype=XSD.decimal)))

        g.add((location_uri, ns['hasCity'], Literal(row['BORO'], datatype=XSD.string)))
        g.add((location_uri, ns['hasState'], Literal(row['BORO'], datatype=XSD.string)))
        g.add((location_uri, ns['hasStreet'], Literal(row['LOCATION_DESC'], datatype=XSD.string)))

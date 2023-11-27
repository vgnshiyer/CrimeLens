'''
Author: Vignesh Iyer
Date: 11/17/2023
'''

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

from data_integration_engine import DataLoader

INPUT_FILES_PATH = [
    'raw_data/NYPD_Shooting_Incident_Data__Historic_.csv',
    'raw_data/Crime_Data_from_2020_to_Present.csv',
    'raw_data/homicide-data.csv']
    
OUTPUT_FILE_PATH = 'fuseki/datasets/crime_lens.ttl'

column_mappings = {
    'hasCrimeID': [
        'INCIDENT_KEY',
        'uid',
        'DR_NO'
    ],
    'hasCrimeDate': [
        'OCCUR_DATE',
        'reported_date',
        'DATE OCC'
    ],
    'hasClassification': [
        'Crm Cd Desc'
    ],
    'VictimHasAge': [
        'VIC_AGE_GROUP',
        'victim_age',
        'Vict Age'
    ],
    'VictimHasGender': [
        'VIC_SEX',
        'victim_sex',
        'Vict Sex'
    ],
    'VictimHasRace': [
        'VIC_RACE',
        'vitcim_race',
        'Vict Descent'
    ],
    'PerpHasAge': [
        'PERP_AGE_GROUP'
    ],
    'PerpHasGender': [
        'PERP_SEX'
    ],
    'PerpHasRace': [
        'PERP_RACE',
    ],
    'hasLatitude': [
        'Latitude',
        'lat',
        'LAT'
    ],
    'hasLongitude': [
        'Longitude',
        'lon',
        'LON'
    ],
    'hasCity': [
        'BORO',
        'city',
        'AREA NAME'
    ],
    'hasState': [
        'state',
    ],
    'hasStreet': [
        'LOCATION_DESC'
        'Street',
        'LOCATION'
    ]
}

def main():
    data_loader = DataLoader(OUTPUT_FILE_PATH, column_mappings)
    for input_file_path in INPUT_FILES_PATH:
        data_loader.read_csv(input_file_path)
        data_loader.create_graph()
    data_loader.save_graph()

if __name__ == '__main__':
    main()
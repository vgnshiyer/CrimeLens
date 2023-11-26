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
    # 'raw_data/NYPD_Shooting_Incident_Data__Historic_.csv',
    # 'raw_data/Crime_Data_from_2020_to_Present.csv',
    # 'raw_data/homicide-data.csv'
    "raw_data/All_Crime_Data.csv"
    # "NYPD_Shooting_Incident_Data__Historic_.csv"
    ]
    
OUTPUT_FILE_PATH = 'fuseki/datasets/crime_lens.ttl'

column_mappings = {
    'hasCrimeID': [
        'id'
    ],
    'hasCrimeDate': [
        'crime_date'
    ],
    'hasClassification': [
        "description"
    ],
    'VictimHasAge': [
        'victim_age_range'
    ],
    'VictimHasGender': [
        'victim_sex'
    ],
    'VictimHasRace': [
        'vitcim_race'
    ],
    'PerpHasAge': [
        'perpetrator_age'
    ],
    'PerpHasGender': [
        'perpetrator_sex'
    ],
    'PerpHasRace': [
        'perpetrator_race'
    ],
    'hasLatitude': [
        'lat'
    ],
    'hasLongitude': [
        'long'
    ],
    'hasCity': [
        'city'
    ],
    'hasState': [
        'state',
    ],
    'hasStreet': [
        'street'
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
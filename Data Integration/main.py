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

INPUT_FILES_PATH = "raw_data/All_Crime_Data.csv"
OUTPUT_FILE_PATH = 'fuseki/datasets/crime_lens.ttl'


def main():
    data_loader = DataLoader(OUTPUT_FILE_PATH)
    data_loader.read_csv(INPUT_FILES_PATH)
    data_loader.create_graph()
    data_loader.save_graph()

if __name__ == '__main__':
    main()
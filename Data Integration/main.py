'''
Author: Vignesh Iyer
Date: 11/17/2023
'''

from data_integration_engine import DataLoader

INPUT_FILE_PATH = 'raw_data/NYPD_Shooting_Incident_Data__Historic_.csv'
OUTPUT_FILE_PATH = 'fuseki/datasets/crime_lens.ttl'

def main():
    data_loader = DataLoader(INPUT_FILE_PATH, OUTPUT_FILE_PATH)
    data_loader.read_csv()
    data_loader.create_graph()
    data_loader.save_graph()

if __name__ == '__main__':
    main()
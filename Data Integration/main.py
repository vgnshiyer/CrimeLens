'''
Author: Vignesh Iyer
Date: 11/17/2023
'''

from data_preprocessor import DataPreprocessor

INPUT_FILE_PATH = 'raw_data/NYPD_Shooting_Incident_Data__Historic_.csv'
OUTPUT_FILE_PATH = 'fuseki/datasets/crime_lens.ttl'

def main():
    data_preprocessor = DataPreprocessor(INPUT_FILE_PATH, OUTPUT_FILE_PATH)
    data_preprocessor.read_csv()
    data_preprocessor.create_graph()
    data_preprocessor.save_graph()

if __name__ == '__main__':
    main()
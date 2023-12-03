import pandas as pd
import numpy as np

nypd_data = pd.read_csv("./raw_data/NYPD_Shooting_Incident_Data__Historic_.csv")
crime_data = pd.read_csv("./raw_data/Crime_Data_from_2020_to_Present.csv")
police_killing_data = pd.read_csv("./raw_data/PoliceKillingsUS.csv", nrows=7000, encoding='cp1252')
homicide_data = pd.read_csv("./raw_data/homicide-data.csv", nrows=36000, encoding='cp1252')

race_mapping = {
    'H': 'Hispanic or Latino',
    'W': 'White',
    'B': 'Black or African American',
    'O': 'Other',
    'A': 'Asian',
    'X': 'Unknown',
    'K': 'Native Hawaiian or Other Pacific Islander',
    'F': 'Filipino',
    'C': 'Chinese',
    'J': 'Japanese',
    'V': 'Vietnamese',
    'I': 'Indian (Asian)',
    'Z': 'Asian Indian',
    'P': 'Pacific Islander',
    'U': 'Guamanian or Chamorro',
    'D': 'Aleut or Eskimo',
    'G': 'Asian or Pacific Islander',
    'L': 'Laotian',
    'S': 'Samoan'
}

nypd_data_mapping = {
    "INCIDENT_KEY": "crime_id",
    "OCCUR_DATE": "crime_date",
    "VIC_AGE_GROUP": "victim_age",
    "VIC_SEX": "victim_sex",
    "VIC_RACE": "victim_race",
    "PERP_AGE_GROUP": "perpetrator_age",
    "PERP_SEX": "perpetrator_sex",
    "PERP_RACE": "perpetrator_race",
    "BORO": "street",
    "Latitude": "lat",
    "Longitude": "long"
}
nypd_data_cols = ["crime_id", "crime_date", "victim_age", "victim_sex", "victim_race", 
                   "perpetrator_age", "perpetrator_sex", "perpetrator_race", "street", "lat", "long"]

all_cols = ["crime_id", "crime_date", "description", "victim_age", "victim_age_range", "victim_sex", "victim_race", 
            "perpetrator_age", "perpetrator_sex", "perpetrator_race", 
            "street", "city", "state", "lat", "long"]

crime_data_mapping = {
    "DR_NO": "crime_id",
    "Date Rptd": "crime_date",
    "Crm Cd Desc": "description",
    "Vict Age": "victim_age",
    "Vict Sex": "victim_sex",
    "Vict Descent": "victim_race",
    "LOCATION": "street",
    "LAT": "lat",
    "LON": "long"
}
crime_data_cols = ["id", "crime_id", "crime_date", "description", "victim_age", "victim_sex", "victim_race", 
                   "street", "lat", "long"]

police_killing_mapping = {
    "id": "crime_id",
    "date": "crime_date",
    "manner_of_death": "description",
    "age": "victim_age",
    "gender": "victim_sex",
    "race": "victim_race"
}
police_killing_cols = ["crime_id", "crime_date", "description", "victim_age", "victim_sex", "victim_race", 
                  "city", "state"]

homicide_mapping = {
    "uid": "crime_id",
    "reported_date": "crime_date",
    "lon": "long"
}
homicide_cols = ["crime_id", "crime_date", "victim_age", "victim_sex", "victim_race", 
                  "city", "state", "lat", "long"]

nypd_data = nypd_data.rename(columns=nypd_data_mapping)[nypd_data_cols]
crime_data = crime_data.rename(columns=crime_data_mapping)[crime_data_cols]
police_killing_data = police_killing_data.rename(columns=police_killing_mapping)[police_killing_cols]
homicide_data = homicide_data.rename(columns=homicide_mapping)[homicide_cols]

nypd_data.loc[:, "description"] = ""
nypd_data.loc[:, "city"] = "New York"
nypd_data.loc[:, "state"] = "NY"

crime_data.loc[:, "perpetrator_age"] = np.NaN
crime_data.loc[:, "perpetrator_sex"] = np.NaN
crime_data.loc[:, "perpetrator_race"] = np.NaN

crime_data.loc[:, "city"] = "Los Angeles"
crime_data.loc[:, "state"] = "CA"

police_killing_data.loc[:, "perpetrator_age"] = np.NaN
police_killing_data.loc[:, "perpetrator_sex"] = np.NaN
police_killing_data.loc[:, "perpetrator_race"] = np.NaN
police_killing_data.loc[:, "street"] = np.NaN
police_killing_data.loc[:, "lat"] = np.NaN
police_killing_data.loc[:, "long"] = np.NaN

homicide_data.loc[:, "perpetrator_age"] = np.NaN
homicide_data.loc[:, "perpetrator_sex"] = np.NaN
homicide_data.loc[:, "perpetrator_race"] = np.NaN
homicide_data.loc[:, "description"] = np.NaN
homicide_data.loc[:, "street"] = np.NaN

nypd_data = nypd_data.query("perpetrator_age.notna() and perpetrator_age!='(null)' and perpetrator_age!='UNKNOWN' \
                            and perpetrator_age!='940' and perpetrator_age!='224' and perpetrator_age!='1020'")
nypd_data = nypd_data.query("victim_age.notna() and victim_age!='(null)' and victim_age!='UNKNOWN' \
                and victim_age!='1022'")

nypd_data = nypd_data.reset_index(drop=True)

crime_data = crime_data.query("victim_age>0 and victim_age<100 and victim_race.notna()")

crime_data.loc[(crime_data.victim_age<18), "victim_age_range"] = "<18"
crime_data.loc[(crime_data.victim_age>=18) & (crime_data.victim_age<=24), "victim_age_range"] = "18-24"
crime_data.loc[(crime_data.victim_age>=25) & (crime_data.victim_age<=44), "victim_age_range"] = "25-44"
crime_data.loc[(crime_data.victim_age>=45) & (crime_data.victim_age<=64), "victim_age_range"] = "45-64"
crime_data.loc[(crime_data.victim_age>=65), "victim_age_range"] = "65+"

nypd_data.crime_date = pd.to_datetime(nypd_data.crime_date)
crime_data.crime_date = pd.to_datetime(crime_data.crime_date)
police_killing_data.crime_date = pd.to_datetime(police_killing_data.crime_date)
homicide_data.crime_date = pd.to_datetime(homicide_data.crime_date, format='%Y%m%d')

police_killing_data = police_killing_data.query("victim_age.notna() and victim_race.notna()")
police_killing_data.victim_age = police_killing_data.victim_age.astype("int")

police_killing_data.loc[(police_killing_data.victim_age<18), "victim_age_range"] = "<18"
police_killing_data.loc[(police_killing_data.victim_age>=18) & (police_killing_data.victim_age<=24), \
                        "victim_age_range"] = "18-24"
police_killing_data.loc[(police_killing_data.victim_age>=25) & (police_killing_data.victim_age<=44), \
                        "victim_age_range"] = "25-44"
police_killing_data.loc[(police_killing_data.victim_age>=45) & (police_killing_data.victim_age<=64), \
                        "victim_age_range"] = "45-64"
police_killing_data.loc[(police_killing_data.victim_age>=65), "victim_age_range"] = "65+"

crime_data.victim_race = crime_data.victim_race.replace(race_mapping)

police_killing_data.victim_race = police_killing_data.victim_race.replace(race_mapping)

homicide_data = homicide_data.query("victim_age.notna() and victim_race.notna() and victim_age!='Unknown'")

homicide_data.victim_age = homicide_data.victim_age.astype("int")

homicide_data.loc[(homicide_data.victim_age<18), "victim_age_range"] = "<18"
homicide_data.loc[(homicide_data.victim_age>=18) & (homicide_data.victim_age<=24), \
                        "victim_age_range"] = "18-24"
homicide_data.loc[(homicide_data.victim_age>=25) & (homicide_data.victim_age<=44), \
                        "victim_age_range"] = "25-44"
homicide_data.loc[(homicide_data.victim_age>=45) & (homicide_data.victim_age<=64), \
                        "victim_age_range"] = "45-64"
homicide_data.loc[(homicide_data.victim_age>=65), "victim_age_range"] = "65+"

crime_data = crime_data.groupby('victim_age_range', group_keys=False, sort=False)\
                .apply(lambda x: x.sample(min(len(x), 5500)))

nypd_data.loc[:, "victim_age_range"] = nypd_data.victim_age

nypd_data.loc[:, "description"] = "Shooting"
homicide_data.loc[:, "description"] = "Homicide"

crime_data_final = pd.concat([nypd_data[all_cols], crime_data[all_cols]], axis=0)
crime_data_final = pd.concat([crime_data_final, police_killing_data[all_cols]], axis=0)
crime_data_final = pd.concat([crime_data_final, homicide_data[all_cols]], axis=0)

crime_data_final = crime_data_final.reset_index(drop=True)
crime_data_final = crime_data_final.reset_index().rename(columns={"index": "id"})

crime_data_final.to_csv("./raw_data/All_Crime_Data.csv", index=False)


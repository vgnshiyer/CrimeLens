# SER531-Fall2023-team4
# Crimelens: A Semantic Web Application for Crime Data Exploration

## Description
Crimelens is a Semantic Web Application designed to amalgamate diverse crime datasets into a unified knowledge graph, thereby enabling effective crime data exploration and analysis. This project integrates various crime data sources and leverages a well-defined ontology to represent knowledge, which is then hosted on a cloud platform.

## Features
- Comprehensive data integration from multiple crime data sources.
- Enhanced querying and analysis capabilities through a knowledge graph.
- User-friendly application interface for easy interaction with the data.
- Utilization of OWL ontology for standardized data representation.
- Powerful tools for visualizing crime data and generating reports.


## Installation and Usage
Follow these steps to set up the project:

0. **Install Gradle:** Make sure Gradle is installed on your system. If not, install it from [Gradle's official website](https://gradle.org/install/).

1. **Prepare Data:**
   - Create a `raw_data` folder in the project directory.
   - Include the datasets in the `raw_data` folder.

2. **Set Up Fuseki Server:**
   - Navigate to `Data Integration/fuseki`.
   - Execute the following commands:
     a. Build the Docker image:
        ```
        docker build -t fuseki .
        ```
     b. Run the Docker image:
        ```
        docker run -p 3030:3030 fuseki
        ```

3. **Run the Spring Boot Application:**
   - For Windows:
     - Change directory to `Application Server`.
     - Execute `gradle.bat bootRun`.
   - For Mac:
     - Change directory to `Application Server`.
     - Run `./gradlew bootRun`.

4. **Setup for Frontend:**
   - Navigate to the `WebApp` directory.
   - Run the following commands:
     ```
     npm install
     npm run dev
     ```

Alternatively, you can set up the entire project by running `docker-compose up` in the root directory.

# API Documentation

## Crime Event API Endpoints

### Base URL
`/api/crime`

#### 1. Get All Crime Events
- **Endpoint**: `/`
- **Method**: `GET`
- **Query Parameters**: 
  - `limit` (optional, integer): Limits the number of results.
  - `date` (optional, string): Filters events by date.
  - `classification` (optional, string): Filters events by classification.
- **Description**: Retrieves a list of all crime events.

#### 2. Get Crime Event by ID
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Path Variables**:
  - `id` (integer): The ID of the crime event.
- **Description**: Retrieves a specific crime event by ID.

#### 3. Get Crime Events by Location
- **Endpoint**: `/location/{locationId}`
- **Method**: `GET`
- **Path Variables**:
  - `locationId` (integer): The ID of the location.
- **Description**: Retrieves crime events based on location ID.

#### 4. Get Crime Events by Date
- **Endpoint**: `/date/{date}`
- **Method**: `GET`
- **Path Variables**:
  - `date` (string): The date of the crime events.
- **Description**: Retrieves crime events based on a specific date.

#### 5. Get Crime Events by Victim
- **Endpoint**: `/victim/{victimId}`
- **Method**: `GET`
- **Path Variables**:
  - `victimId` (integer): The ID of the victim.
- **Description**: Retrieves crime events related to a specific victim.

#### 6. Get Crime Events by Perpetrator
- **Endpoint**: `/perpetrator/{perpetratorId}`
- **Method**: `GET`
- **Path Variables**:
  - `perpetratorId` (integer): The ID of the perpetrator.
- **Description**: Retrieves crime events related to a specific perpetrator.

#### 7. Get Crime Events by Classification
- **Endpoint**: `/classification/{classification}`
- **Method**: `GET`
- **Path Variables**:
  - `classification` (string): The classification of the crime.
- **Description**: Retrieves crime events based on their classification.

#### 8. Get Victims by Crime Event
- **Endpoint**: `/{id}/victims`
- **Method**: `GET`
- **Path Variables**:
  - `id` (integer): The ID of the crime event.
- **Description**: Retrieves victims related to a specific crime event.

#### 9. Get Perpetrators by Crime Event
- **Endpoint**: `/{id}/perpetrators`
- **Method**: `GET`
- **Path Variables**:
  - `id` (integer): The ID of the crime event.
- **Description**: Retrieves perpetrators related to a specific crime event.

#### 10. Create Crime Event
- **Endpoint**: `/`
- **Method**: `POST`
- **Request Body**: `CrimeEvent` object.
- **Description**: Creates a new crime event record.

#### 11. Update Crime Event
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Path Variables**:
  - `id` (integer): The ID of the crime event to update.
- **Request Body**: `CrimeEvent` object with updated data.
- **Description**: Updates the details of a specific crime event.

#### 12. Delete Crime Event
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Path Variables**:
  - `id` (integer): The ID of the crime event to delete.
- **Description**: Deletes a specific crime event record.

## Perpetrator API Endpoints

### Base URL
`/api/perpetrator`

#### 1. Get All Perpetrators
- **Endpoint**: `/`
- **Method**: `GET`
- **Query Parameters**:
  - `limit` (optional, integer): Limits the number of results.
- **Description**: Retrieves a list of all perpetrators.

#### 2. Get Perpetrator by ID
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Path Variables**:
  - `id` (integer): The ID of the perpetrator.
- **Description**: Retrieves a specific perpetrator by ID.

#### 3. Get Perpetrators by Age
- **Endpoint**: `/age/{age}`
- **Method**: `GET`
- **Path Variables**:
  - `age` (integer): The age of the perpetrators.
- **Description**: Retrieves perpetrators filtered by age.

#### 4. Get Perpetrators by Race
- **Endpoint**: `/race/{race}`
- **Method**: `GET`
- **Path Variables**:
  - `race` (string): The race of the perpetrators.
- **Description**: Retrieves perpetrators filtered by race.

#### 5. Get Perpetrators by Gender
- **Endpoint**: `/gender/{gender}`
- **Method**: `GET`
- **Path Variables**:
  - `gender` (string): The gender of the perpetrators.
- **Description**: Retrieves perpetrators filtered by gender.

#### 6. Update Perpetrator by ID
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Path Variables**:
  - `id` (integer): The ID of the perpetrator to update.
- **Request Body**: `Perpetrator` object with updated data.
- **Description**: Updates the details of a specific perpetrator.

#### 7. Create Perpetrator
- **Endpoint**: `/`
- **Method**: `POST`
- **Request Body**: `Perpetrator` object.
- **Description**: Adds a new perpetrator record.

#### 8. Delete Perpetrator by ID
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Path Variables**:
  - `id` (integer): The ID of the perpetrator to delete.
- **Description**: Deletes a specific perpetrator record.

## Victim API Endpoints

### Base URL
`/api/victim`

#### 1. Get All Victims
- **Endpoint**: `/`
- **Method**: `GET`
- **Query Parameters**:
  - `limit` (optional, integer): Limits the number of results.
- **Description**: Retrieves a list of all victims.

#### 2. Get Victim by ID
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Path Variables**:
  - `id` (integer): The ID of the victim.
- **Description**: Retrieves a specific victim by ID.

#### 3. Get Victims by Age
- **Endpoint**: `/age/{age}`
- **Method**: `GET`
- **Path Variables**:
  - `age` (integer): The age of the victims.
- **Description**: Retrieves victims filtered by age.

#### 4. Get Victims by Race
- **Endpoint**: `/race/{race}`
- **Method**: `GET`
- **Path Variables**:
  - `race` (string): The race of the victims.
- **Description**: Retrieves victims filtered by race.

#### 5. Get Victims by Gender
- **Endpoint**: `/gender/{gender}`
- **Method**: `GET`
- **Path Variables**:
  - `gender` (string): The gender of the victims.
- **Description**: Retrieves victims filtered by gender.

#### 6. Update Victim by ID
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Path Variables**:
  - `id` (integer): The ID of the victim to update.
- **Request Body**: `Victim` object with updated data.
- **Description**: Updates the details of a specific victim.

#### 7. Create Victim
- **Endpoint**: `/`
- **Method**: `POST`
- **Request Body**: `Victim` object.
- **Description**: Adds a new victim record.

#### 8. Delete Victim by ID
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Path Variables**:
  - `id` (integer): The ID of the victim to delete.
- **Description**: Deletes a specific victim record.


## License
This project is licensed under the GNU General Public License Version 3. For more details, see [GNU General Public License](https://www.gnu.org/licenses/gpl-3.0.html).

## Authors and Acknowledgment
- Chaitya Dharmeshbhai Sanghavi: `<csanghav@asu.edu>`
- Vignesh Venkatachalam Iyer: `<viyer10@asu.edu>`
- Devanshu Amitkumar Desai: `<ddesai21@asu.edu>`
- Naga Venkata Sri Sai Eshwar Gulupalli: `<ngulupal@asu.edu>`
- Naga Venkata Dharani Viswanadh Chinta: `<nvchinta@asu.edu>`

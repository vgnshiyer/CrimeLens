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

## System Architecture
![System Architecture Diagram](link-to-diagram)

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
   - Change directory to `Application Server`.
   - Execute `gradle.bat bootRun`.

4. **Local Configuration:**
   - Since the application is running locally, replace all occurrences of `datastore` with `localhost` in the configuration.

5. **Accessing the Data:**
   - Access the data using the APIs. Refer to the `controllers` folder for the endpoints.

Alternatively, you can set up the entire project by running `docker-compose up` in the root directory.


## License
This project is licensed under the GNU General Public License Version 3. For more details, see [GNU General Public License](https://www.gnu.org/licenses/gpl-3.0.html).

## Authors and Acknowledgment
- Chaitya Dharmeshbhai Sanghavi: `<csanghav@asu.edu>`
- Vignesh Venkatachalam Iyer: `<viyer10@asu.edu>`
- Devanshu Amitkumar Desai: `<ddesai21@asu.edu>`
- Naga Venkata Sri Sai Eshwar Gulupalli: `<ngulupal@asu.edu>`
- Naga Venkata Dharani Viswanadh Chinta: `<nvchinta@asu.edu>`

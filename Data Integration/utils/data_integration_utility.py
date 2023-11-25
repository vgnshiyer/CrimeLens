from dateutil.parser import parse
import re

def format_date(date: str) -> str:
    """Format a date.

    Args:
        date (str): A date.

    Returns:
        str: Converts date in the format of 'YYYY-MM-DD' from DD/MM/YYYY.
    """
    try:
        date_object = parse(date)
    except:
        date_object = parse('01/01/1111')

    return date_object.strftime('%Y-%m-%d')

def format_crime_id(crime_id: str) -> str:
    """Format a crime ID.

    Args:
        crime_id (str): A crime ID.

    Returns:
        str: Removes all characters, special chars and converts to integer
    """
    return int(re.sub('\D', '', crime_id))

def get_row_information(row, col_keys):
    """Get row information.

    Args:
        row (dict): A row.
        col_keys (list): A list of column keys.

    Returns:
        str: The value of the first column key that exists in the row.
    """
    return_val = ''
    for col in col_keys:
        if col in row:
            return_val = row[col]
            break
    return return_val
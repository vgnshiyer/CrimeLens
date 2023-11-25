import random
from datetime import datetime

def format_date(date: str) -> str:
    """Format a date.

    Args:
        date (str): A date.

    Returns:
        str: Converts date in the format of 'YYYY-MM-DD' from DD/MM/YYYY.
    """
    
    date_object = datetime.strptime(date, '%m/%d/%Y')

    return date_object.strftime('%Y-%m-%d')
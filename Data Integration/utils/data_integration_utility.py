import random
from datetime import datetime

def generate_random_id() -> str:
    """Generate a random ID.

    Returns:
        str: A random ID.
    """
        
    return str(random.randint(1, 1000000000))

def format_date(date: str) -> str:
    """Format a date.

    Args:
        date (str): A date.

    Returns:
        str: Converts date in the format of 'YYYY-MM-DD' from DD/MM/YYYY.
    """
    
    date_object = datetime.strptime(date, '%m/%d/%Y')

    return date_object.strftime('%Y-%m-%d')
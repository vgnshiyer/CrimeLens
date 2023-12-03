export function getFilteredDate(filter) {
    let currentDate = new Date();
    let filteredDate;

    switch (filter) {
        case "LAST_7_DAYS":
            filteredDate = new Date(currentDate.setDate(currentDate.getDate() - 7));
            break;
        case "LAST_30_DAYS":
            filteredDate = new Date(currentDate.setDate(currentDate.getDate() - 30));
            break;
        case "LAST_180_DAYS":
            filteredDate = new Date(currentDate.setDate(currentDate.getDate() - 180));
            break;
        case "LAST_1_YEAR":
            filteredDate = new Date(currentDate.setDate(currentDate.getDate() - 365));
            break;
        case "LAST_5_YEARS":
            filteredDate = new Date(currentDate.setDate(currentDate.getDate() - 1825));
            break;
        case "LAST_10_YEARS":
            filteredDate = new Date(currentDate.setDate(currentDate.getDate() - 3650));
            break;
        default:
            filteredDate = currentDate;
    }

    const formattedDate = `${filteredDate.getFullYear()}-${('0' + (filteredDate.getMonth() + 1)).slice(-2)}-${('0' + filteredDate.getDate()).slice(-2)}`;

    return formattedDate;
}

export function getDateDifferenceInDays(date) {
    const currentDate = new Date();
    const givenDate = new Date(date);

    const differenceInTime = currentDate.getTime() - givenDate.getTime();
    const differenceInDays = differenceInTime / (1000 * 3600 * 24);

    return differenceInDays;
}

export function getDayOfTheWeek(date) {
    const dateParts = date.split('-');
    const day = new Date(dateParts[0], dateParts[1] - 1, dateParts[2]).getDay();
    const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    return days[day];
}

export function getMonth(date) {
    const dateParts = date.split('-');
    const month = new Date(dateParts[0], dateParts[1] - 1, dateParts[2]).getMonth();
    const months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

    return months[month];
}
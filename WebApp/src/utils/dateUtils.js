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
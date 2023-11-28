import MapComponent from './MapComponent'
import Pie from './PieComponent'
import CrimeFeed from './CrimeFeed'
import Filter from './Filter'

export default function Dashboard() {
    return (
        <div style={{ display: 'flex', justifyContent: 'space-between' }}>
            <div style={{ width: '20%' }}>
                <Filter />
            </div>
            <div style={{ display: 'flex', flexDirection: 'column', width: '60%' }}>
                <MapComponent />
                <Pie />
            </div>
            <div style={{ width: '20%' }}>
                <CrimeFeed />
            </div>
        </div>
    );
}

/**
 * 
 * map component
 * pie chart component
 * bar char component
 * crime type filter
 * crime feed
 */

import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

export default function Profile() {
    return (
        <div>
            <h1 style={{ marginTop: "30px", color: "#eae2b7" }}>Crimelens: A Semantic Web Application for Crime Data Exploration</h1>
            <p style={{ padding: "10px 20px" }}>Crime data is typically dispersed across numerous sources,
                each with its own format, taxonomy, and context. This frag-
                mented landscape of crime-related information poses chal-
                lenges for comprehensively analyzing and deriving insights
                from these datasets. The Crimelens project recognizes that
                linked data, characterized by the interconnection of data el-
                ements, holds the potential to bridge this gap by providing
                a standardized framework for the integration and analysis of
                crime data</p>
            <div style={{
                display: "flex",
                flexWrap: "wrap",
                gap: "20px", justifyContent: "center", marginTop: "50px"
            }}>
                <Card sx={{ minWidth: 275, background: "#023d8a81" }}>
                    <CardContent>
                        <Typography sx={{ fontSize: 14, color: "#fdf0d5" }} gutterBottom>
                            Chaitya Dharmeshbhai Sanghavi
                            <br />
                            Computer Software Engineering
                            <br />
                            Arizona State University
                            <br />
                            Tempe, United States
                            <br />
                            Email: csanghav@asu.edu
                        </Typography>
                    </CardContent>
                </Card>
                <Card sx={{ minWidth: 275, background: "#023d8a81" }}>
                    <CardContent>
                        <Typography sx={{ fontSize: 14, color: "#fdf0d5" }} gutterBottom>
                            Vignesh Venkatachalam Iyer
                            <br />
                            Computer Software Engineering
                            <br />
                            Arizona State University
                            <br />
                            Tempe, United States
                            <br />
                            Email: viyer10@asu.edu
                        </Typography>
                    </CardContent>
                </Card>
                <Card sx={{ minWidth: 275, background: "#023d8a81" }}>
                    <CardContent>
                        <Typography sx={{ fontSize: 14, color: "#fdf0d5" }} gutterBottom>
                            Devanshu Amitkumar Desai
                            <br />
                            Computer Software Engineering
                            <br />
                            Arizona State University
                            <br />
                            Tempe, United States
                            <br />
                            Email: ddesai21@asu.edu
                        </Typography>
                    </CardContent>
                </Card>
                <Card sx={{ minWidth: 275, background: "#023d8a81" }}>
                    <CardContent>
                        <Typography sx={{ fontSize: 14, color: "#fdf0d5" }} gutterBottom>
                            Naga Venkata Sri Sai Eshwar Gulupalli
                            <br />
                            Computer Software Engineering
                            <br />
                            Arizona State University
                            <br />
                            Tempe, United States
                            <br />
                            Email: ngulupal@asu.edu
                        </Typography>
                    </CardContent>
                </Card>
                <Card sx={{ minWidth: 275, background: "#023d8a81" }}>
                    <CardContent>
                        <Typography sx={{ fontSize: 14, color: "#fdf0d5" }} gutterBottom>
                            Naga Venkata Dharani Viswanadh Chinta
                            <br />
                            Computer Software Engineering
                            <br />
                            Arizona State University
                            <br />
                            Tempe, United States
                            <br />
                            Email: nvchinta@asu.edu
                        </Typography>
                    </CardContent>
                </Card>
            </div>
        </div >
    )
}

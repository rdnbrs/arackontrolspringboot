import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import axios from 'axios';

function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
        <Typography
            component="div"
            role="tabpanel"
            hidden={value !== index}
            id={`wrapped-tabpanel-${index}`}
            aria-labelledby={`wrapped-tab-${index}`}
            {...other}
        >
            {value === index && <Box p={3}>{children}</Box>}
        </Typography>
    );
}

TabPanel.propTypes = {
    children: PropTypes.node,
    index: PropTypes.any.isRequired,
    value: PropTypes.any.isRequired,
};

function a11yProps(index) {
    return {
        id: `wrapped-tab-${index}`,
        'aria-controls': `wrapped-tabpanel-${index}`,
    };
}

const useStyles = makeStyles(theme => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.paper,
    },
}));

function getAllDataFromApi(){
    fetch('http://localhost:8080/arac/tumaraclar', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    })
}

function getDataFromApi(id){
    fetch('http://localhost:8080/arac/'+id, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    })
}

function postDataToApi(){

    //axios.get("http://localhost:8080/arac/tumaraclar").then(response=>console.log(response.data))
    let aracAdi = this.refs.aracAdi.input.value;
    let muhimmat = this.refs.muhimmat.input.value;
    let yakit = this.refs.yakit.input.value;
    let hasarDurum = this.refs.hasarDurum.input.value;

    fetch('http://localhost:8080/arac', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            aracAdi: aracAdi,
            muhimmat: muhimmat,
            yakit:yakit,
            hasarDurum:hasarDurum
        })
    }).then(response=>console.log(response.data))
}

export default function TabsWrappedLabel() {
    const classes = useStyles();
    const [value, setValue] = React.useState('one');

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Tabs value={value} onChange={handleChange} aria-label="wrapped label tabs example">
                    <Tab
                        value="one"
                        label="Araç Yükle"
                        wrapped
                        {...a11yProps('one')}
                    />
                    <Tab value="two" label="Araç Bilgileri" {...a11yProps('two')} />
                </Tabs>
            </AppBar>
            <TabPanel value={value} index="one">
                <form className={classes.root} noValidate autoComplete="off">
                    <TextField id="outlined-basic" label="Araç Adı" variant="outlined" name="aracAdi" ref="aracAdi"/>&nbsp;
                    <TextField id="outlined-basic" label="Mühimmat (Adet)" variant="outlined" type="number" name="muhimmat" ref="muhimmat"/>&nbsp;
                    <TextField id="outlined-basic" label="Yakıt (LT)" variant="outlined" name="yakit" ref="yakit"/>&nbsp;
                    <TextField id="outlined-basic" label="Hasasr Durumu (%)" variant="outlined" name="hasarDurum" ref="hasarDurum"/>&nbsp;
                    <Button variant="contained" color="primary" onClick={postDataToApi}>
                        Kaydet
                    </Button>
                </form>
            </TabPanel>
            <TabPanel value={value} index="two">
                Item Twoasdfadsf
            </TabPanel>
        </div>
    );
}
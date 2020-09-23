import React,{Component} from 'react';
import Header from './HeaderComponent';
import Home from './HomeComponent';
import { Switch, Route, Redirect } from 'react-router-dom'; 
import Footer from './FooterComponent';

class Main extends Component {
    render () {

        const HomePage =() => {
            return (
                <Home />
            )
        }

        return(
            <div>
                <Header />
                <Switch>
                    <Route path="/home" component={HomePage} />
                    <Redirect to="/home" />
                </Switch>
                <Footer />
                <script src="/__/firebase/7.18.0/firebase-app.js"></script>
                <script src="/__/firebase/7.18.0/firebase-analytics.js"></script>
                <script src="/__/firebase/init.js"></script>
            </div>
        );
    }
};

export default Main;
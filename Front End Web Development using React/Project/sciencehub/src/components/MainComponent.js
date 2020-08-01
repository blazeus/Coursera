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
            </div>
        );
    }
};

export default Main;
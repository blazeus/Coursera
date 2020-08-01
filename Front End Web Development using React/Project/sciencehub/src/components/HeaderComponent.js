import React,{Component} from 'react';
import {Navbar, Nav, Button} from 'react-bootstrap';
import { NavLink } from 'react-router-dom';

class Header extends Component {

    render() {
        return(
            <>
                <Navbar collapseOnSelect fixed="top" variant="light" expand="lg">
                    <div className="container-fluid">
                        <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
                        <Navbar.Collapse id="responsive-navbar-nav">
                            <span className="col-md-6"></span>
                            <Nav className="mr-auto mt-2">
                                <Nav.Item className="col-sm-4">
                                    <NavLink className='nav-link' to='/home'>
                                        <Button block className='nav-blue'>
                                            <span className='nav-link text-light'>Home</span>
                                        </Button>
                                    </NavLink>
                                </Nav.Item>
                                <Nav.Item className="col-sm-4">
                                    <NavLink className='nav-link' to='/home'>
                                        <Button block className='nav-blue'>
                                            <span className='nav-link text-light'>Blog</span>
                                        </Button>
                                    </NavLink>
                                </Nav.Item>
                                <Nav.Item className="col-sm-4">
                                    <NavLink className='nav-link' to='/home' >
                                        <Button className='nav-blue btn-block'>
                                            <span className='nav-link text-light' >Discussion</span>
                                        </Button>
                                    </NavLink>
                                </Nav.Item>
                                <Nav.Item className="col-sm-5">
                                    <NavLink className='nav-link' to='/home'>
                                        <Button className='nav-orange btn-block'>
                                            <span className='nav-link text-light'>Login/Signup</span>
                                        </Button>
                                    </NavLink>
                                </Nav.Item>
                            </Nav>
                        </Navbar.Collapse>
                    </div>
                </Navbar>
            </>
        );
    }
}

export default Header;





import React,{ Component } from 'react';


class Footer extends Component {

    render () {
        return(
            <footer class="footer pr-0">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 col-12">
                            <h2 class="text-light">Navigation</h2>
                            <ul class="list-unstyled">
                                <li>
                                    <a href="#">Home</a>
                                </li>
                                <li>
                                    <a href="#">Blogs</a>
                                </li>
                                <li>
                                    <a href="#">Discussion</a>
                                </li>
                            </ul>

                            <h2 class="text-light">References</h2>
                            <ul class="list-unstyled">
                                <li>
                                    <a href="https://blogs.plos.org">https://blogs.plos.org</a>
                                </li>
                                <li>
                                    <a href="https://www.iflscience.com/">https://www.iflscience.com/</a>
                                </li>
                                <li>
                                    <a href="http://nautil.us/blog">http://nautil.us/blog</a>
                                </li>
                                <li>
                                    <a href="https://www.researchgate.net/">https://www.researchgate.net/</a>
                                </li>
                                <li>
                                    <a href="https://blogs.scientificamerican.com/laelaps/">https://blogs.scientificamerican.com/laelaps/</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-sm-6 col-12">
                            <div class="row">
                                <div class="col-md-8 offset-md-2 col-12 search">
                                    <div class="input-group">
                                        <input type="text" name="search" id="search" class="form-control searchbox" placeholder="Search text" />
                                        <div class="input-group-append">
                                            <span class="input-group-text fa fa-search"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-8 offset-md-2 col-12">
                                    <p class="search-text">Search through a plathora of scietific articles </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        );        
    }
}

export default Footer;
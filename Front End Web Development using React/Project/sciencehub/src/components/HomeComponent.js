import React, { Component } from 'react';


class Home extends Component {
    render() {
        return(
            <div>
                <div class="container-fluid introduction">
                    <div class="row">
                        <div class="col-md-5 offset-md-1">
                            <h1 class="display-md-3 display-4 text-light">Meet Science Hub</h1>
                            <br />
                            <p class="text-justify text-light">A platform to share your knowledge related to science and ask questions to quench
                                your thirst of knowledge.
                            </p>
                        </div>
                        <div class="offset-md-1 col-md-5">
                            <img src="/assets/Img/Blob + image.svg" alt="" class="img-fluid intro-img" />
                        </div>
                    </div>
                </div>

                {/* blogs card */}
                <div class="container-fluid article">
                    <div class="row">
                        <div class="col-md-10 col-12 offset-md-1">
                            <div class="card">
                                <div class="card-body">
                                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam maxime impedit harum quo earum iure laudantium id labore nemo molestias totam qui, placeat dicta enim voluptatum saepe consequuntur reiciendis facere.</p>  
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body">
                                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam maxime impedit harum quo earum iure laudantium id labore nemo molestias totam qui, placeat dicta enim voluptatum saepe consequuntur reiciendis facere.</p>  
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body">
                                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam maxime impedit harum quo earum iure laudantium id labore nemo molestias totam qui, placeat dicta enim voluptatum saepe consequuntur reiciendis facere.</p>  
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-body">
                                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam maxime impedit harum quo earum iure laudantium id labore nemo molestias totam qui, placeat dicta enim voluptatum saepe consequuntur reiciendis facere.</p>  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
} 

export default Home;
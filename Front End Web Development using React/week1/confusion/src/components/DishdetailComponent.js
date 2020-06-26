import React, { Component } from 'react';
import {Card, CardImg, CardText, CardBody, CardTitle} from 'reactstrap';

class DishDetail extends Component {
    constructor(props){
        super(props);
    }

    renderDish(dish){
        if (this.props.dish != null) {
            return (  
                <Card>
                    <CardImg width="100%" src={this.props.dish.image} alt={this.props.dish.name}></CardImg>
                    <CardBody>
                        <CardTitle>
                            <h4>
                                {this.props.dish.name}
                            </h4>
                        </CardTitle>
                        <CardText>
                            {this.props.dish.description}
                        </CardText>
                    </CardBody>
                </Card>
            );
        }
        else {
            return(
                <div></div>
            );
        }
    }

    renderComment(dish) {
        var commentSection = null;
        if (this.props.dish != null){
            commentSection = this.props.dish.comments.map((comment) =>{
                return(
                    <div key={comment.id}>
                        <CardText className="list-unstyled">
                                <p>
                                    {comment.comment}
                                </p>
                                <p>
                                    --{comment.author},{comment.date}
                                </p>
                        </CardText>
                    </div>
                )
            });
        }

        <CardBody>
            <CardTitle>
                <h4>
                    Comments
                </h4>
            </CardTitle>
            {commentSection}
        </CardBody>
    }


    render() {
        return(
            <div className="container">
                <div className="row">
                    <div className="col-md-5 m-1 col-12">
                        {this.renderDish(this.props.dish)}
                    </div>
                    <div className="col-md-5 col-12">
                        {this.renderComment(this.props.dish)}
                    </div>
                </div>
            </div>
        );
    }
};

export default DishDetail;
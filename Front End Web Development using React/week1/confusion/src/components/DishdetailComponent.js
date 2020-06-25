import React, { Component } from 'react';
import {Card, CardImg, CardText, CardBody, CardTitle} from 'reactstrap';

class DishDetail extends Component {
    constructor(props){
        super(props);

    }

    renderDish(dish){
        var commentSection = null;
        if (this.props.dish != null){
            commentSection = this.props.dish.comments.map((comment) =>{
                return(
                    <div key={comment.id}>
                        <CardText className="unstyled-list">
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

        if (this.props.dish != null) {
            return (
                <div className="row">
                    <div className="col-md-5 m-1 col-12">
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
                    </div>
                    <div className="col-md-5 m-1 col-12">
                        <CardBody>
                            <CardTitle>
                                <h4>
                                    Comments
                                </h4>
                            </CardTitle>
                            {commentSection}
                        </CardBody>
                    </div>
                </div>
            );
        }
        else {
            return(
                <div></div>
            )
        }
    }


    render() {
        return(
            <div className="container">
                {this.renderDish(this.props.dish)}
            </div>
        )};
};

export default DishDetail;
import React, { Component } from 'react';
import {Card, CardImg, CardText, CardBody, CardTitle} from 'reactstrap';

class DishDetail extends Component {
    constructor(props){
        super(props);

    }


    renderComments(dish){
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
                                    --{comment.author} {new Intl.DateTimeFormat('en-US',{year:'numeric', month:'short', day:'2-digit'}).format(new Date(Date.parse(comment.date)))}
                                </p>
                        </CardText>
                    </div>
                )
            });
        }

        if (this.props.dish != null) {
            return (
                <CardBody>
                    <CardTitle>
                        <h4>
                            Comments
                        </h4>
                    </CardTitle>
                    {commentSection}
                </CardBody>
            );
        }
        else {
            return(
                <div></div>
            )
        }

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
            )
        }
    }


    render() {
        return(
            <div className="container">
                <div className="row">
                    <div className="col-md-5 m-1 col-12">
                        {this.renderDish(this.props.dish)}
                    </div>
                    <div className="col-md-5 col-12">
                        {this.renderComments(this.props.dish)}
                    </div>
                </div>
            </div>
        )};
};

export default DishDetail;
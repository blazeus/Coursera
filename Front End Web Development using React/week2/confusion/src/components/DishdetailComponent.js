import React from 'react';
import {Card, CardImg, CardText, CardBody, CardTitle} from 'reactstrap';

function RenderComments({comments}){
    const commentSection = comments.map((comment) =>{
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

function RenderDish({dish}){
    return (
        <Card>
            <CardImg width="100%" src={dish.image} alt={dish.name}></CardImg>
            <CardBody>
                <CardTitle>
                    <h4>
                        {dish.name}
                    </h4>
                </CardTitle>
                <CardText>
                    {dish.description}
                </CardText>
            </CardBody>
        </Card>
    );
}


const DishDetail = (props) => {
    if(props.dish != null) {
        return(
            <div className="container">
                <div className="row">
                    <div className="col-md-5 m-1 col-12">
                        <RenderDish dish = {props.dish} />
                    </div>
                    <div className="col-md-5 col-12">
                        <RenderComments comments = {props.dish.comments} />
                    </div>
                </div>
            </div>
        );
    } else {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-md-5 m-1 col-12"></div>
                    <div className="col-md-5 col-12"></div>
                </div>
            </div>
        )
    }
}

export default DishDetail;
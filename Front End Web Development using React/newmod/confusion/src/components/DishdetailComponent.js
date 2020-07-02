import React from 'react';
import {Card, CardImg, CardText, CardBody, CardTitle, Breadcrumb, BreadcrumbItem} from 'reactstrap';
import { Link } from 'react-router-dom';

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
                    Comments
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
                        {dish.name}
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
                    <Breadcrumb>
                        <BreadcrumbItem><Link to='/menu'>Menu</Link></BreadcrumbItem>
                        <BreadcrumbItem active>{props.dish.name}</BreadcrumbItem>
                    </Breadcrumb>
                    <div className="col-12">
                        <h3>{props.dish.name}</h3>
                        <hr/>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-5 m-1 col-12">
                        <RenderDish dish = {props.dish} />
                    </div>
                    <div className="col-md-5 col-12">
                        <RenderComments comments = {props.comments} />
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
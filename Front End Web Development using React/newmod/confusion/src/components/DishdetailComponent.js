import React, { Component } from 'react';
import {Card, CardImg, CardText, CardBody, CardTitle, Breadcrumb, BreadcrumbItem,
        Button, Modal, ModalHeader, ModalBody, Col, Row, Label  } from 'reactstrap';
import { Link } from 'react-router-dom';
import { LocalForm, Errors, Control } from 'react-redux-form';

const maxLength = (len) => (val) => !(val) || (val.length <= len);
const minLength = (len) => (val) => !(val) || (val.length >= len);

class CommentForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isModalOpen : false
        };

        this.toggleModal = this.toggleModal.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    toggleModal() {
        this.setState({
            isModalOpen: !this.state.isModalOpen
        });
    }

    handleSubmit (values){
        this.toggleModal();
        this.props.addComment(this.props.dishId, values.rating, values.author, values.comment);
    }

    render() {
        return(
            <div className="container">
                <Button outline onClick={this.toggleModal}>
                    <span outline className='fa fa-pencil'> Submit Comment</span>
                </Button>
            
                <Modal isOpen={this.state.isModalOpen} toggle={this.toggleModal}>
                    <ModalHeader toggle={this.toggleModal}>
                        Submit Comment
                    </ModalHeader>
                    <ModalBody>
                        <LocalForm onSubmit={(values) => this.handleSubmit(values)}>
                            <Row className='form-group'>
                                <Col md={12}>
                                    <Label htmlFor='rating'>Rating</Label>
                                </Col>
                                <Col md={12}>
                                    <Control.select
                                        className='form-control'
                                        name='rating'
                                        id='rating'
                                        model='.rating'
                                    >
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </Control.select>
                                </Col>
                            </Row>
                            <Row className='form-group'>
                                <Col md={12}>
                                    <Label htmlFor='author'>Your Name</Label>
                                </Col>
                                <Col md={12}>
                                    <Control.text 
                                        className='form-control'
                                        id='author'
                                        model='.author'
                                        name='author' placeholder='Your Name'

                                        validators={{
                                            minLength: minLength(3), maxLength: maxLength(15)
                                        }}
                                    />
                                    <Errors
                                        className="text-danger"
                                        model='.author'
                                        show='touched'
                                        messages ={{
                                            minLength: 'Must be greater than 2 characters ',
                                            maxLength: 'Must be 15 characters or less '
                                        }}
                                    /> 
                                </Col>
                            </Row>
                            <Row className='form-group'>
                                <Col md={12}>
                                    <Label htmlFor='comment'>Comment</Label>
                                </Col>
                                <Col>
                                    <Control.textarea 
                                        name='comment'
                                        model='.comment'
                                        id='comment'
                                        rows='6'
                                        className='form-control'
                                    />
                                </Col>
                            </Row>
                            <Row className="form-group">
                                <Col>
                                    <Button type="submit" color="primary">
                                        Submit
                                    </Button>
                                </Col>
                            </Row>
                        </LocalForm>
                    </ModalBody>
                </Modal>
            </div>
        );
    }
}

function RenderComments({comments, addComment, dishId}){
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
            <CardText>
                {commentSection}
                <CommentForm dishId={dishId} addComment={addComment} />
            </CardText>
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
                        <RenderComments comments = {props.comments} 
                            addComment={props.addComment}
                            dishId={props.dish.id} 
                        />
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
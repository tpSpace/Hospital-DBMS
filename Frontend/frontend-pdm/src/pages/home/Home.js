import React from 'react';
import styles from './Home.module.css';

const Home = () => {
    return (
        <div className={styles.container}>
            <section className={styles.one}>
                <div className={styles.left}>
                    <h1>We follow a holistic approach to health care.</h1>
                    <p>your money is our goal.</p>
                    <button>Book an Appointment</button>
                </div>
                <div className={styles.right}>
                    <img src={require('../../resource/doctorF.png')} width="346px" height="464px" alt="a female doctor"/>
                </div>
            </section>
            <section id="two">
                <div className={styles.title}>
                    <h4>SERVIES</h4>
                    <h2>Experienced in multiple medical practices</h2>
                    <p>Our hospital offers the very highest standards of clinical skills and nursing care across a wide range of specialties.</p>
                    <div className={styles.categories}>
                        <div className={styles.category}>
                            <img src={require('../../resource/cardiology.png')} alt="category1" width="50px" height="50px"/>
                            <h3>Cardiology</h3>
                            <p>Our cardiology department is one of the best in the country.</p>
                        </div>
                        <div className={styles.category}>
                            <img src={require('../../resource/neurology.png')} alt="category2" width="50px" height="50px"/>
                            <h3>Neurology</h3>
                            <p>Our neurology department is one of the best in the country.</p>
                        </div>
                        <div className={styles.category}>
                            <img src={require('../../resource/dentistry.png')} alt="category3" width="50px" height="50px"/>
                            <h3>Dentistry</h3>
                            <p>Our dentistry department is one of the best in the country.</p>
                        </div>
                        <div className={styles.category}>
                            <img src={require('../../resource/eye.png')} alt="category4" width="50px" height="50px"/>
                            <h3>Ophthalmology</h3>
                            <p>Our ophthalmology department is one of the best in the country.</p>
                        </div>
                    </div>
                </div>
            </section>
            <section className={styles.three}>
                <div className={styles.title}>
                    <h4>BENEFITS</h4>
                    <p>Watch video to learn why you should use our servies</p>
                </div>
                <div className={styles.video}>
                    <iframe  src="https://www.youtube.com/embed/2MEy18SPIDM" title="Healthway Medical Corporate Video" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
            </section>
            <footer className={styles.footer}>
                <div className={styles.info}>
                    <div className={styles.logo}>
                        <img src={require('../../resource/hospital.png')} alt="logo" width="50px" height="50px"/>
                        <p>Healthway Medical</p>
                    </div>
                    <div className={styles.desc}>   
                        <p>A good laugh and a long sleep are the best cures in the doctor's book</p>
                    </div>
                </div>

                <div className={styles.contact}>
                    <h4>Contact Us</h4>
                    <p>Phone: +1 234 567 890</p>
                    <p>Email: Heygirl@hotmail.com</p>
                    <p>Address: 1234 Main St, New York, NY 10001</p>
                </div>

                <div className={styles.social}>
                    <h4>Social Media</h4>
                    <div className={styles.icons}>
                        <img src={require('../../resource/facebook.png')} alt="facebook" width="30px" height="30px"/>
                        <img src={require('../../resource/twitter.png')} alt="twitter" width="30px" height="30px"/>
                        <img src={require('../../resource/instagram.png')} alt="instagram" width="30px" height="30px"/>
                        <img src={require('../../resource/youtube.png')} alt="youtube" width="30px" height="30px"/>
                    </div>
                </div>
            </footer>
        </div>
    );
};

export default Home;
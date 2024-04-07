import React, { useEffect, useState } from 'react';
import { animateScroll } from 'react-scroll';

const Scroll = () => {
    const [scrolled, setScrolled] = useState(false);


    useEffect(() => {
        const scrollFunction = async () => {
            if (window.scrollY < 100)
                animateScroll.scrollTo(100);
            else if (window.scrollY > 100) {
                animateScroll.scrollTo(0);
                await new Promise(resolve => setTimeout(resolve, 1001));
                animateScroll.scrollTo(100);
            }
        };

        scrollFunction();

        return () => {

        };
    }, []);


    return <div />;
};

export default Scroll;

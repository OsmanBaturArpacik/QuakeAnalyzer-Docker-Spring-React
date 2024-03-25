import React, { useEffect } from 'react';
// TODO
// Scroll animasyon ver baslangıçta 100 px aşağı kaysın
const Scroll = () => {
    useEffect(() => {
        const handleScroll = () => {
            const currentScrollPosition = window.scrollY;
            const targetScrollPosition = currentScrollPosition + 100;

            if (performance.navigation.type !== 1) {
                window.scrollTo({
                    top: targetScrollPosition,
                    behavior: 'smooth'
                });
            }
        };
        window.addEventListener('load', handleScroll);
        window.addEventListener('beforeunload', handleScroll);
        // Clean-up
        return () => {
            window.removeEventListener('load', handleScroll);
            window.removeEventListener('beforeunload', handleScroll);
        };
    }, []);

    return (
        <div>
        </div>
    );
};

export default Scroll;

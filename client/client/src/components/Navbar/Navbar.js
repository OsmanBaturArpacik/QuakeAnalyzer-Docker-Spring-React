import "./navbar.css"
import logoHome from "../../resources/image/home.svg";
import React, {Component} from "react";
import PropTypes from "prop-types";
class Navbar extends Component {
    render() {
    return(
        <nav className="nav">
            <a href="/" className="site-title">
                <img src={logoHome} className="home-logo" alt="logo"/>
                Earthquake
            </a>
            <ul>
                {/*<CustomLink href="/Test" rel={"noopener noreferrer"}>Test</CustomLink>*/}
                <CustomLink href="https://kartaca.com/" target="_blank" rel={"noopener noreferrer"}>Kartaca</CustomLink>
                <CustomLink href="https://www.linkedin.com/in/osman-batur-arpacik/" target="_blank" rel={"noopener noreferrer"}>LinkedIn</CustomLink>
            </ul>
        </nav>

        )
    }
}
// Navbar.defaultProps = {
//
// }
// Navbar.propTypes = {
//     link : PropTypes.string.isRequired
// }

function CustomLink({ href, children, ...props}) {
    const path = window.location.pathname
    return (
        <li className={path === href ? "active" : ""}>
            <a href={href} {...props}>{children}</a>
        </li>
    )
}
export default Navbar;
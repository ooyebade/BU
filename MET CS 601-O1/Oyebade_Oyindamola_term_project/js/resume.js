// handle button onclick actions
const url_resume = "https://gist.githubusercontent.com/ooyebade/35bd9e20924a25fdaa1363bc96ce4bfe/raw/c5efc9c4d7d0c640d0fd01e1d484cd7a87f0fc80/resume.json";
makeRequest(url_resume);

// takes url, creates XMLHttpRequest to fetch data
function makeRequest(url_resume) {

    let httpRequest  = new XMLHttpRequest();

    if (!httpRequest ) {
        alert("Cannot create an XMLHTTP instance");
        return false;
    }

    httpRequest.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let dataObj = JSON.parse(this.responseText);
            appendData(dataObj);
        }
    };
    httpRequest.open("GET", url_resume, true);
    httpRequest.send();
}

// append data fetched in table format
function appendData(resume) {

    const header = resume.header;
    $('#header #full-name').append(
        $(`<span>${header.name.first}</span>`).attr({ id: `first-name`, class: `first-name` }),
        $(`<span>${header.name.last}</span>`).attr({ id: `last-name`, class: `last-name` })
    );
    $('#header #contact #email').append(header.contact.email);
    $('#header #contact #phone').append(header.contact.phone);
    $('#header #contact #website').append($(`<a href="${header.contact.website}">${header.contact.website}</a>`));

    const educationArr = resume.education;
    educationArr.forEach(education => {
        let edu_ele = $(`<div/>`, { class: `ele` }).appendTo(`#education`);
        edu_ele.append(
            $(`<div>`, { class: `flex-row` }).append(
                $(`<div>${education.name}</div>`).attr({ class: `name` }),
                $(`<div>${education.location}</div>`).attr({ class: `location` })
            ),
            $(`<div>`, { class: `flex-row` }).append(
                $(`<div>${education.degree}</div>`).attr({ class: `degree` }),
                $(`<div>${education.duration}</div>`).attr({ class: `duration` })
            )
        );
        let courses = $(`<ul/>`, { class: `flex-row courses` }).appendTo(edu_ele);
        education.courses.forEach(course => {
            courses.append(
                $(`<li>${course}</li>`, { class: `edu-course-li`})
            );
        });
    });

    
    const skills = resume.skills;
    const languages = skills.languages.join(', ');
    const frameworks = skills.frameworks.join(', ');
    const tools = skills.tools.join(', ');
    $(`#skills`).append(
        $(`<div>`, { class: `row`, id: `skills-categories` }).append(
            $(`<div>Languages</div>`).attr({ class: `languages col-3` }),
            $(`<div>Frameworks</div>`).attr({ class: `frameworks col-3` }),
            $(`<div>Tools/Cloud Platforms & Services</div>`).attr({ class: `tools col-6` })
        ),
        $(`<div>`, { class: `row`, id: `skills-items`}).append(
            $(`<div>${languages}</div>`).attr({ class: `col-3` }),
            $(`<div>${frameworks}</div>`).attr({ class: `col-3` }),
            $(`<div>${tools}</div>`).attr({ class: `col-6` })
        )
    );
    
    const experienceArr = resume.experience;
    experienceArr.forEach(exp => {
        let exp_ele = $(`<div/>`, { class: `ele` }).appendTo(`#experience`);
        exp_ele.append(
            $(`<div>`, { class: `row` }).append(
                $(`<div>${exp.title}</div>`).attr({ class: `col-5 job-title` }),
                $(`<div>${exp.loc}</div>`).attr({ class: `col-4 loc` }),
                $(`<div>${exp.duration}</div>`).attr({ class: `col-3 align-right duration` })
            )
        );
        let descriptions = $(`<ul/>`, { class: `desc list-pad` }).appendTo(exp_ele);
        exp.desc.forEach(desc => {
            descriptions.append(
                $(`<li>${desc}</li>`, { class: `exp-desc-li`})
            );
        });
    });

};

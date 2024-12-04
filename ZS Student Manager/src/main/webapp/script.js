

/** Page references */

const home_page = document.querySelector(".home-page");
const add_student_page = document.querySelector(".add-student-page");
const view_student_page = document.querySelector(".view-student-page");

/** Button references */

const view_student_btn = document.getElementById("view-student-btn");
const add_student_btn = document.getElementById("add-student-btn");
const save_btn = document.getElementById("save-btn");
const save_back_btn = document.getElementById("save-back-btn");
const view_student_back_btn = document.getElementById("view-student-back-btn");

/** Home page action */
view_student_btn.addEventListener("click", () => {
    home_page.classList.remove("flex-container");
	home_page.classList.add("hidden");
	view_student_page.classList.remove("hidden");
	view_student_page.classList.add("block-container");
});

add_student_btn.addEventListener("click", () => {

    home_page.classList.remove("flex-container");
    home_page.classList.add("hidden");

    add_student_page.classList.remove("hidden");
    add_student_page.classList.add("block-container");
})

/** View Student Page  Action*/

view_student_back_btn.addEventListener("click", () => {
	
	view_student_page.classList.remove("block-container");
	view_student_page.classList.add("hidden");
	
	home_page.classList.remove("hidden");
	home_page.classList.add("flex-container");
   

})

/** Add Student Page Action */

save_back_btn.addEventListener("click", () => {
	add_student_page.classList.remove("block-container");
	add_student_page.classList.add("hidden");
	home_page.classList.remove("hidden");
	home_page.classList.add("flex-container");
})

save_btn.addEventListener("click", () => {
	const newStudentJson = getNewStudentJson();
	const jsonStr = JSON.stringify(newStudentJson);
	postCall(jsonStr);
});


function getNewStudentJson() {
	const firstName = document.getElementById("first-name").value;
	const lastName = document.getElementById("last-name").value;
	const dateOfBirth = document.getElementById("date-of-birth").value;
	const gender = document.querySelector('input[name="gender"]:checked').value;
	const mobileNumber = document.getElementById("mobile-number").value;
	const emailId = document.getElementById("email-id").value;
	const department = document.getElementById("department").value;
	const yearOfPassout = document.getElementById("year-of-passout").value;
	const location = document.getElementById("location").value;

	const fromData = {
		firstName: firstName,
		lastName: lastName,
		dateOfBirth: dateOfBirth,
		gender: gender,
		mobileNumber: mobileNumber,
		emailId: emailId,
		department: department,
		yearOfPassout: yearOfPassout,
		location: location,
	};
	return fromData;
}

function postCall(jsonStr) {

	let promiseRes = fetch("addZSStudentServlet", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: jsonStr
	})
	promiseRes.then(response => {
		if (!response.ok) {
			throw new Error("Network response was not ok");
		}
		return response.json();
	})
	promiseRes.then(data => {
		console.log(data);
	}).catch(error => {
			alert(error);
	});
}

view_student_btn.addEventListener("click", show);

function show(event) {
	let content = '';
	event.preventDefault();
	const list = fetch("getZSStudentList");

	list.then(response => {

		if (!response.ok) {
			throw new Error("Response not ok");
		}
		return response.json();
	})
		.then(data => {
			if (Array.isArray(data) && data.length > 0) {
				data.forEach(student => {
					content += `<tr style = "padding : 10px">
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.dateOfBirth}</td>
                        <td>${student.gender}</td>
                        <td>${student.mobileNumber}</td>
                        <td>${student.emailID}</td>
                        <td>${student.department}</td>
                        <td>${student.yearOfPassout}</td>
                    	<td>${student.location}</td>
                    </tr>`;
				});
			} else {
				content = `<tr><td colspan="8">No students found</td></tr>`;
			}
		}).then(() => {
			document.getElementById('dynRow').innerHTML = content;
		})
		.catch(error => {
			alert(error);
		})

}



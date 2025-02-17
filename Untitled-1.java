<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .error { color: red; font-size: 14px; }
        form { max-width: 400px; margin: auto; }
        label, input { display: block; width: 100%; margin-top: 10px; }
        button { margin-top: 20px; }
    </style>
</head>
<body>
    <form id="registrationForm">
        <label>First Name:
            <input type="text" id="firstName">
            <span class="error" id="firstNameError"></span>
        </label>
        
        <label>Last Name:
            <input type="text" id="lastName">
            <span class="error" id="lastNameError"></span>
        </label>
        
        <label>Email:
            <input type="email" id="email">
            <span class="error" id="emailError"></span>
        </label>
        
        <label>Password:
            <input type="password" id="password">
            <span class="error" id="passwordError"></span>
        </label>
        
        <label>Confirm Password:
            <input type="password" id="confirmPassword">
            <span class="error" id="confirmPasswordError"></span>
        </label>
        
        <label>Age:
            <input type="number" id="age">
            <span class="error" id="ageError"></span>
        </label>
        
        <label>Phone Number (XXX-XXX-XXXX):
            <input type="text" id="phoneNumber">
            <span class="error" id="phoneError"></span>
        </label>
        
        <button type="button" onclick="validateForm()">Submit</button>
    </form>

    <script>
        function validateForm() {
            let valid = true;
            
            // Clear previous errors
            document.querySelectorAll(".error").forEach(el => el.textContent = "");
            
            let firstName = document.getElementById("firstName").value.trim();
            let lastName = document.getElementById("lastName").value.trim();
            let email = document.getElementById("email").value.trim();
            let password = document.getElementById("password").value;
            let confirmPassword = document.getElementById("confirmPassword").value;
            let age = document.getElementById("age").value;
            let phoneNumber = document.getElementById("phoneNumber").value;
            
            // First Name Validation
            if (firstName.length < 2) {
                document.getElementById("firstNameError").textContent = "First name must be at least 2 characters.";
                valid = false;
            }
            
            // Last Name Validation
            if (lastName.length < 2) {
                document.getElementById("lastNameError").textContent = "Last name must be at least 2 characters.";
                valid = false;
            }
            
            // Email Validation
            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                document.getElementById("emailError").textContent = "Enter a valid email.";
                valid = false;
            }
            
            // Password Validation
            let passwordPattern = /^(?=.*[A-Z])(?=.*\d).{8,}$/;
            if (!passwordPattern.test(password)) {
                document.getElementById("passwordError").textContent = "Password must be at least 8 characters, contain one uppercase letter and one number.";
                valid = false;
            }
            
            // Confirm Password Validation
            if (confirmPassword !== password) {
                document.getElementById("confirmPasswordError").textContent = "Passwords do not match.";
                valid = false;
            }
            
            // Age Validation (if provided)
            if (age && (age < 18 || age > 100)) {
                document.getElementById("ageError").textContent = "Age must be between 18 and 100.";
                valid = false;
            }
            
            // Phone Number Validation (if provided)
            let phonePattern = /^\d{3}-\d{3}-\d{4}$/;
            if (phoneNumber && !phonePattern.test(phoneNumber)) {
                document.getElementById("phoneError").textContent = "Enter a valid phone number (XXX-XXX-XXXX).";
                valid = false;
            }
            
            if (valid) {
                let formData = {
                    firstName: firstName,
                    lastName: lastName,
                    email: email,
                    password: password,
                    age: age ? Number(age) : undefined,
                    phoneNumber: phoneNumber || undefined
                };
                console.log("JSON Output:", JSON.stringify(formData, null, 2));
            }
        }
    </script>
</body>
</html>

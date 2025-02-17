const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }));

app.post('/login', (req, res) => {
    console.log("Login request received:", req.body); // Debug log
  
    const { username, password } = req.body;
    const validUsername = 'admin';
    const validPassword = '12345';
  
    if (username === validUsername && password === validPassword) {
      res.json({ success: true });
    } else {
      res.json({ success: false });
    }
  });

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});

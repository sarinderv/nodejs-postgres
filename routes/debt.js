const express = require('express');
const router = express.Router();
const debt = require('../services/debt');

/* GET debt listing. */
router.get('/', async function(req, res, next) {
  try {
    res.json(await debt.getMultiple(req.query.page));
  } catch (err) {
    console.error(`Error while getting debt `, err.message);
    res.status(err.statusCode || 500).json({'message': err.message});
  }
});

/* POST debt */
router.post('/', async function(req, res, next) {
  try {
    res.json(await debt.create(req.body));
  } catch (err) {
    console.error(`Error while posting debt `, err.message);
    res.status(err.statusCode || 500).json({'message': err.message});
  }
});

module.exports = router;

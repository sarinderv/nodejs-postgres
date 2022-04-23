const express = require('express');
const router = express.Router();
const macroeconomic = require('../services/macroeconomic');

/* GET macroeconomic listing. */
router.get('/', async function(req, res, next) {
  try {
    res.json(await macroeconomic.getMultiple(req.query.page));
  } catch (err) {
    console.error(`Error while getting macroeconomic `, err.message);
    res.status(err.statusCode || 500).json({'message': err.message});
  }
});

/* POST macroeconomic */
router.post('/', async function(req, res, next) {
  try {
    res.json(await macroeconomic.create(req.body));
  } catch (err) {
    console.error(`Error while posting macroeconomic `, err.message);
    res.status(err.statusCode || 500).json({'message': err.message});
  }
});

module.exports = router;

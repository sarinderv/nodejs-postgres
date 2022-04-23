const express = require('express');
const router = express.Router();
const agricultural = require('../services/agricultural');

/* GET agricultural listing. */
router.get('/', async function(req, res, next) {
  try {
    res.json(await agricultural.getMultiple(req.query.page));
  } catch (err) {
    console.error(`Error while getting agricultural `, err.message);
    res.status(err.statusCode || 500).json({'message': err.message});
  }
});

/* POST agricultural */
router.post('/', async function(req, res, next) {
  try {
    res.json(await agricultural.create(req.body));
  } catch (err) {
    console.error(`Error while posting agricultural `, err.message);
    res.status(err.statusCode || 500).json({'message': err.message});
  }
});

module.exports = router;

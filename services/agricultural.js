const db = require('./db');
const helper = require('../helper');
const config = require('../config');

async function getMultiple(page = 1) {
  const offset = helper.getOffset(page, config.listPerPage);
  const rows = await db.query(
    'SELECT year,country,manufactoringPercentageOfGDP,agrValueAdded,fertilizerConsumptionPerHectare,fertilizerConsumptionPercentage FROM agricultural OFFSET $1 LIMIT $2', 
    [offset, config.listPerPage]
  );
  const data = helper.emptyOrRows(rows);
  const meta = {page};

  return {
    data,
    meta
  }
}

function validateCreate(agricultural) {
  let messages = [];

  console.log(agricultural);

  if (!agricultural) {
    messages.push('No object is provided');
  }

  if (!agricultural.year) {
    messages.push('agricultural has no year');
  }

  if (!agricultural.country) {
    messages.push('agricultural has no country');
  }

  if (messages.length) {
    let error = new Error(messages.join());
    error.statusCode = 400;

    throw error;
  }
}

async function create(agricultural){
  validateCreate(agricultural);

  const result = await db.query(
    'INSERT INTO agricultural(year,country,manufactoringPercentageOfGDP,agrValueAdded,fertilizerConsumptionPerHectare,fertilizerConsumptionPercentage) VALUES ($1, $2, $3, $4, $5, $6) RETURNING *',
    [agricultural.year,agricultural.country,agricultural.manufactoringPercentageOfGDP,agricultural.agrValueAdded,agricultural.fertilizerConsumptionPerHectare,agricultural.fertilizerConsumptionPercentage]
  );
  let message = 'Error in creating agricultural row';

  if (result.length) {
    message = 'agricultural row created successfully';
  }

  return {message};
}

module.exports = {
  getMultiple,
  create
}

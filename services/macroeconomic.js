const db = require('./db');
const helper = require('../helper');
const config = require('../config');

async function getMultiple(page = 1) {
  const offset = helper.getOffset(page, config.listPerPage);
  const rows = await db.query(
    'SELECT year, country, gdpCurrentUSD, gdpAnnualGrowthPercentage, currentAccountBalance, fdiNetUSD, fdiNetInflowsPercentage, fdiNetOutflowsPercentage FROM macroeconomic OFFSET $1 LIMIT $2', 
    [offset, config.listPerPage]
  );
  const data = helper.emptyOrRows(rows);
  const meta = {page};

  return {
    data,
    meta
  }
}

function validateCreate(macroeconomic) {
  let messages = [];

  console.log(macroeconomic);

  if (!macroeconomic) {
    messages.push('No object is provided');
  }

  if (!macroeconomic.year) {
    messages.push('macroeconomic has no year');
  }

  if (!macroeconomic.country) {
    messages.push('macroeconomic has no country');
  }

  if (messages.length) {
    let error = new Error(messages.join());
    error.statusCode = 400;

    throw error;
  }
}

async function create(macroeconomic){
  validateCreate(macroeconomic);

  const result = await db.query(
    'INSERT INTO macroeconomic(year, country, gdpCurrentUSD, gdpAnnualGrowthPercentage, currentAccountBalance, fdiNetUSD, fdiNetInflowsPercentage, fdiNetOutflowsPercentage) VALUES ($1, $2, $3, $4, $5, $6, $7, $8) RETURNING *',
    [macroeconomic.year, macroeconomic.country, macroeconomic.usd]
  );
  let message = 'Error in creating macroeconomic row';

  if (result.length) {
    message = 'macroeconomic row created successfully';
  }

  return {message};
}

module.exports = {
  getMultiple,
  create
}

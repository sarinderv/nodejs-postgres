const db = require('./db');
const helper = require('../helper');
const config = require('../config');

async function getMultiple(page = 1) {
  const offset = helper.getOffset(page, config.listPerPage);
  const rows = await db.query(
    'SELECT year,country,totalReservesInMonths,totalReserves,currentGNI,totalReservesPercentage,debtServiceTotal,debtServicePercentage FROM debt OFFSET $1 LIMIT $2', 
    [offset, config.listPerPage]
  );
  const data = helper.emptyOrRows(rows);
  const meta = {page};

  return {
    data,
    meta
  }
}

function validateCreate(debt) {
  let messages = [];

  console.log(debt);

  if (!debt) {
    messages.push('No object is provided');
  }

  if (!debt.year) {
    messages.push('debt has no year');
  }

  if (!debt.country) {
    messages.push('debt has no country');
  }

  if (messages.length) {
    let error = new Error(messages.join());
    error.statusCode = 400;

    throw error;
  }
}

async function create(debt){
  validateCreate(debt);

  const result = await db.query(
    'INSERT INTO debt(year,country,totalReservesInMonths,totalReserves,currentGNI,totalReservesPercentage,debtServiceTotal,debtServicePercentage) VALUES ($1, $2, $3, $4, $5, $6, $7, $8) RETURNING *',
    [debt.year,debt.country,debt.totalReservesInMonths,debt.totalReserves,debt.currentGNI,debt.totalReservesPercentage,debt.debtServiceTotal,debt.debtServicePercentage]
  );
  let message = 'Error in creating debt row';

  if (result.length) {
    message = 'debt row created successfully';
  }

  return {message};
}

module.exports = {
  getMultiple,
  create
}

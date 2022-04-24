var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var quotesRouter = require('./routes/quotes');
var macroeconomicRouter = require('./routes/macroeconomic');
var agriculturalRouter = require('./routes/agricultural');
var debtRouter = require('./routes/debt');

var app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/quotes', quotesRouter);
app.use('/macroeconomic', macroeconomicRouter);
app.use('/agricultural', agriculturalRouter);
app.use('/debt',debtRouter);

module.exports = app;

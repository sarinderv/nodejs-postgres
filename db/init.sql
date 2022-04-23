CREATE TABLE quote (
    id SERIAL PRIMARY KEY,
    quote character varying(255) NOT NULL UNIQUE,
    author character varying(255) NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO quote (id, quote, author) VALUES 
(1, 'There are only two kinds of languages: the ones people complain about and the ones nobody uses.', 'Bjarne Stroustrup'), 
(2, 'Any fool can write code that a computer can understand. Good programmers write code that humans can understand.', 'Martin Fowler'), 
(3, 'First, solve the problem. Then, write the code.', 'John Johnson'), 
(4, 'Java is to JavaScript what car is to Carpet.', 'Chris Heilmann'), 
(5, 'Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.', 'John Woods'), 
(6, 'I''m not a great programmer; I''m just a good programmer with great habits.', 'Kent Beck'), 
(7, 'Truth can only be found in one place: the code.', 'Robert C. Martin'), 
(8, 'If you have to spend effort looking at a fragment of code and figuring out what it''s doing, then you should extract it into a function and name the function after the "what".', 'Martin Fowler'), 
(9, 'The real problem is that programmers have spent far too much time worrying about efficiency in the wrong places and at the wrong times; premature optimization is the root of all evil (or at least most of it) in programming.', 'Donald Knuth'), 
(10, 'SQL, Lisp, and Haskell are the only programming languages that I’ve seen where one spends more time thinking than typing.', 'Philip Greenspun'), 
(11, 'Deleted code is debugged code.', 'Jeff Sickel'), 
(12, 'There are two ways of constructing a software design: One way is to make it so simple that there are obviously no deficiencies and the other way is to make it so complicated that there are no obvious deficiencies.', 'C.A.R. Hoare'), 
(13, 'Simplicity is prerequisite for reliability.', 'Edsger W. Dijkstra'), 
(14, 'There are only two hard things in Computer Science: cache invalidation and naming things.', 'Phil Karlton'), 
(15, 'Measuring programming progress by lines of code is like measuring aircraft building progress by weight.', 'Bill Gates'), 
(16, 'Controlling complexity is the essence of computer programming.', 'Brian Kernighan'),
(17, 'The only way to learn a new programming language is by writing programs in it.', 'Dennis Ritchie');

CREATE TABLE macroeconomic (
    year integer,
    country character varying(255) NOT NULL,
    gdpCurrentUSD numeric,
    gdpAnnualGrowthPercentage numeric,
    currentAccountBalance numeric,
    fdiNetUSD numeric,
    fdiNetInflowsPercentage numeric,
    fdiNetOutflowsPercentage numeric,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY(year, country)
);

INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1960,'India',37029883875,3.722742533,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1961,'India',39232435784,2.931127737,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1962,'India',42161481859,5.994353261,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1963,'India',48421923459,7.452950122,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1964,'India',56480289941,-2.63577011,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1965,'India',59554854575,-0.05532877,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1966,'India',45865462034,7.82596303,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1967,'India',50134942203,3.387929176,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1968,'India',53085455871,6.539700296,NULL,NULL,NULL,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1969,'India',58447995017,5.157229736,NULL,NULL,0.072826324,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1970,'India',62422483055,1.642930384,NULL,NULL,0.070763624,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1971,'India',67350988021,-0.553301312,NULL,NULL,0.024893934,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1972,'India',71463193830,3.295521135,NULL,NULL,0.044331264,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1973,'India',85515269586,1.18533626,NULL,NULL,0.057241382,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1974,'India',99525899116,9.149912015,-0.149804626,0,-0.010486395,NULL);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1975,'India',98472796457,1.663103637,1.537101815,0,-0.007502573,0);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1976,'India',1.03E+11,7.254764586,1.744416029,0,-0.029682109,0);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1977,'India',1.21E+11,5.712532089,0.504279978,0,0.0131755,0);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1978,'India',1.37E+11,-5.238182703,0.03290178,0,0.03174683,0);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1979,'India',1.53E+11,6.735821528,-0.958069194,4000000,0.042484827,0);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1980,'India',1.86E+11,6.006203624,-1.394554633,2000000,0.047506181,0.002146783);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1981,'India',1.93E+11,3.47573324,-1.257276246,1000000,0.03591159,0.001033642);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1982,'India',2.01E+11,7.288892901,-0.887437672,5000000,0.002584047,0.000498219);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1983,'India',2.18E+11,3.820737856,-1.089314216,4000000,0.009068703,0.002290822);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1984,'India',2.12E+11,5.254299223,-1.780805001,3000000,0.045627777,0.001885385);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1985,'India',2.33E+11,4.77656417,-1.834520559,-1000000,0.047283784,0.001290257);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1986,'India',2.49E+11,3.965355634,-1.853242437,5000000,0.076091199,-0.000401629);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1987,'India',2.79E+11,9.62778292,-2.408461745,11000000,0.030766482,0.001791899);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1988,'India',2.97E+11,5.947343328,-2.301281981,10000000,0.085156734,0.003708836);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1989,'India',2.96E+11,5.533454563,-2.191935869,6000000,0.073740021,0.003377895);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1990,'India',3.21E+11,1.056831433,-1.588911312,-11000000,0.02722554,0.001869281);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1991,'India',2.70E+11,5.482396022,-1.556243036,24000000,0.095941829,-0.004072485);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1992,'India',2.88E+11,4.75077622,-0.67161797,350640.5619,0.197056163,0.008327307);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1993,'India',2.79E+11,6.658924067,-0.51219266,82583302.7,0.297385909,0.000125544);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1994,'India',3.27E+11,7.57449184,-1.544131627,117189079.2,0.594986258,0.025233567);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1995,'India',3.60E+11,7.549522249,-1.515954247,239324706.5,0.617479056,0.032527047);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1996,'India',3.93E+11,4.049820849,-0.713014,112918990.4,0.860208566,0.060912828);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1997,'India',4.16E+11,6.184415821,-1.63832471,47593027.49,0.625285966,0.02715262);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1998,'India',4.21E+11,8.845755561,-0.703548206,79357457.32,0.472644846,0.011295327);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (1999,'India',4.59E+11,3.840991157,-0.982343806,509532974.7,0.765212649,0.017295973);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2000,'India',4.68E+11,4.823966264,0.290494936,1054132218,1.056378305,0.108782767);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2001,'India',4.85E+11,3.803975321,1.370941111,1261071115,1.011571805,0.217149393);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2002,'India',5.15E+11,7.860381476,1.443561063,1237846245,0.605889255,0.244897685);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2003,'India',6.08E+11,7.922936613,0.110018664,1837062923,0.765601405,0.203693879);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2004,'India',7.09E+11,7.923430621,-1.253507315,2640754960,0.88610072,0.259051931);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2005,'India',8.20E+11,8.060732573,-0.988988303,14036833332,2.130168425,0.321893491);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2006,'India',9.40E+11,7.660815065,-0.663718193,17026111929,2.073395746,1.492867398);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2007,'India',1.22E+12,3.08669806,-2.583376538,19256527246,3.620521897,1.39932736);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2008,'India',1.20E+12,7.861888833,-1.951464148,16095583747,2.651593127,1.606188857);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2009,'India',1.34E+12,8.497584702,-3.253484046,15968099288,1.635034274,1.199474211);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2010,'India',1.68E+12,5.241315001,-3.429288264,12607994610,2.002065552,0.952969273);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2011,'India',1.82E+12,5.456388753,-5.004888982,8553237671,1.312934337,0.691588004);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2012,'India',1.83E+12,6.386106401,-2.645666243,1764948800,1.516275965,0.467994118);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2013,'India',1.86E+12,7.410227605,-1.33950833,11686480933,1.695658786,0.09505724);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2014,'India',2.04E+12,7.996253786,-1.067549349,7514275639,2.092115758,0.573111845);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2015,'India',2.10E+12,8.256305502,-0.527880354,5047292606,1.937363198,0.357212358);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2016,'India',2.29E+12,6.795383419,-1.439488918,11090150305,1.507316581,0.219944965);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2017,'India',2.65E+12,6.532989011,-2.428608822,11417789536,1.559263523,0.418263755);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2018,'India',2.70E+12,4.041554187,-1.036851495,13140702032,1.763127508,0.422707035);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2019,'India',2.87E+12,-7.964610411,1.25837087,11122667604,NULL,0.457783776);
INSERT INTO macroeconomic(year,country,gdpCurrentUSD,gdpAnnualGrowthPercentage,currentAccountBalance,fdiNetUSD,fdiNetInflowsPercentage,fdiNetOutflowsPercentage) VALUES (2020,'India',2.62E+12,NULL,NULL,NULL,NULL,0.41810685);

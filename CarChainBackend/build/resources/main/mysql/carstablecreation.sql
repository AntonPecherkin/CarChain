CREATE TABLE IF NOT EXISTS cars (
  id INT AUTO_INCREMENT,
  priceAllDays DOUBLE,
  ischained BIT,
  manual BIT,
  websiteId VARCHAR(200),
  vihcle VARCHAR(200),
  startlat double,
  startlon double,
  PRIMARY KEY (id)
)
const { Sequelize, DataTypes } = require("sequelize");
const sequelize = new Sequelize("eventdb", "root", "password", {
    host: "localhost",
    dialect: "mysql",
});

const Event = sequelize.define(
    "Event",
    {
        title: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        description: {
            type: DataTypes.TEXT,
            allowNull: false,
        },
        startDate: {
            type: DataTypes.DATE,
            allowNull: false,
        },
        categories: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        speakers: {
            type: DataTypes.JSON,
            allowNull: false,
        },
    },
    {
        timestamps: true,
    }
);

sequelize.sync();

module.exports = Event;

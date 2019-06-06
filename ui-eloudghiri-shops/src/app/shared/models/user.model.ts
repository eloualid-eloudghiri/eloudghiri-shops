import {Coordinate} from './coordinate.model';


export class User {
    public constructor(
        public id: number,
        public lastName: string,
        public firstName: string,
        public email: string,
        public telephone: string,
        public password: string,
        public token: string,
        public coordinate: Coordinate
    ) {}
}

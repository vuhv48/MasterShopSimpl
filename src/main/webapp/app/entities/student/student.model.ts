export interface IStudent {
  id?: number;
  address?: string | null;
  phone?: string | null;
}

export class Student implements IStudent {
  constructor(public id?: number, public address?: string | null, public phone?: string | null) {}
}

export function getStudentIdentifier(student: IStudent): number | undefined {
  return student.id;
}

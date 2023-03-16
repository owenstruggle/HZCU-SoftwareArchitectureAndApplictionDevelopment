import fetch from '@/config/fetch'

/** 获取全部学生信息 **/
export const getAllUser = data => fetch('/allUser', data, 'GET')

/** 获取学生信息 **/
export const getUser = data => fetch('/user', data, 'GET')

/** 获取全部学生信息 **/
export const addUser = data => fetch('/add', data, 'PUT')
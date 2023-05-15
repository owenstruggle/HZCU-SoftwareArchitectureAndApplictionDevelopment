import fetch from '@/config/fetch'

/** 获取全部学生信息 **/
export const getAllUser = data => fetch('/allUser', data, 'GET')

/** 获取学生信息 **/
export const getUser = data => fetch('/user', data, 'GET')

/** 添加学生信息 **/
export const addUser = data => fetch('/add', data, 'POST')

/** 删除学生信息 **/
export const deleteUser = data => fetch('/delete', data, 'DELETE')

/** 更新学生信息 **/
export const updateUser = data => fetch('/update', data, 'POST')

/** 登录 **/
export const login = data => fetch('/login', data, 'POST')
/**
 * @author Owem
 * @date 2023/3/23 15:26
 * @description 在 store 内进行调用的 storage 对象, 用于进行 store 数据本地化
 */

const storage = {
	set(key, value) {
		sessionStorage.setItem(key, JSON.stringify(value));
	},
	get(key) {
		return JSON.parse(sessionStorage.getItem(key));
	},
	getForIndex(index) {
		return sessionStorage.key(index)
	},
	getKeys() {
		let items = this.getAll();
		let keys = [];
		for (let index = 0; index < items.length; index++) {
			keys.push(items[index].key);
		}
	},
	getLength() {
		return sessionStorage.length;
	},
	getSupport() {
		return (typeof (Storage) !== "undefined");
	},
	remove(key) {
		sessionStorage.removeItem(key);
	},
	removeAll() {
		sessionStorage.clear();
	},
	getAll() {
		let len = sessionStorage.length;
		let arr = [];
		for (let i = 0; i < len.length; i++) {
			const getKey = sessionStorage.key(i);
			const getVal = sessionStorage.getItem(getKey);
			arr[i] = {
				"key": getKey,
				"val": getVal,
			}
		}
		return arr;
	},
};

export default storage;
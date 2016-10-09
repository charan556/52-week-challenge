package mylib

func Average(nums []float64) float64 {
	total := float64(0)
	for _, num := range nums {
		total += num
	}
	return total / float64(len(nums))
}

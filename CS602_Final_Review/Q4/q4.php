<?php
	class Rectangle {
		// Property declarations
		public $width = 0;
        public $height = 0;

		// constructor
		public function __construct($width, $height) {
			$this->width = $width;
            $this->height = $height;
		}
		
        
		public function getArea() {
			return ($this->width * $this->height);
		}
	}

	/** class Square {} */
?>